import * as functions from 'firebase-functions';
import { Request, Response } from 'express';
//import * as cors from 'cors';
import { IMAGES } from './images';
import { STRATIFIED } from './stratified';
import { getRandomIndex } from './util';
import { Choice, ChoiceFactory } from './choice';
import { RandomChoiceFactory } from './random-choice-factory';
import { StratifiedRandomChoiceFactory } from './stratified-random-choice-factory';

const cors = require('cors')({origin: true});
function getSession(): number {
  return getRandomIndex(2147483647);
}
function log(request: Request, session: number, strategy: string): void {
  console.log(`${request.ip} ${session} "${request.url}" "${request.headers["user-agent"]}" ${new Date().getTime()} "${strategy}"`);
}
export const hunger = functions.https.onRequest((request: Request, response: Response) => {
  cors(request, response, () => {
    let session: number = request.query.searchSession;
    if (!session) {
      session = getSession(); 
    }

    // we obviously need to refactor this soon or managing model/strategy
    // selection will get out of hand
    let factory: ChoiceFactory;
    if(session % 2) {
      log(request, session, "random");
      factory = new RandomChoiceFactory(IMAGES);
    } else {
      log(request, session, "stratified");
      factory = new StratifiedRandomChoiceFactory(STRATIFIED);
    }
    const choice = factory.newChoice();
    response.json({searchSession: session, ...choice});
  });
});


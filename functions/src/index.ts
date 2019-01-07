import * as functions from 'firebase-functions';
import { Request, Response } from 'express';
//import * as cors from 'cors';
import { IMAGES } from './images';
import { STRATIFIED } from './stratified';


// Start writing Firebase Functions
// https://firebase.google.com/docs/functions/typescript
//const corsHandler = cors({origin: true});
const cors = require('cors')({origin: true});
function getRandomIndex(setSize: number): number {
  return Math.floor(Math.random() * setSize);
}
function getSession(): number {
  return getRandomIndex(2147483647);
}
function getRandomFood(otherThan?: number): number {
  let food = getRandomIndex(IMAGES.length);    
  while(food === otherThan) {
    food = getRandomIndex(IMAGES.length);
  }
  return food;
}
function getRandomStratifiedFood(otherThan?: Array<number>): Array<number> {
  const strata: number = otherThan ? otherThan[0] : getRandomIndex(STRATIFIED.length); 
  const otherFood: number = otherThan ? otherThan[1] : undefined;
  let food = getRandomIndex(STRATIFIED[strata].length);    
  while(food === otherFood) {
    food = getRandomIndex(STRATIFIED[strata].length);    
  }
  return [strata, food];
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
    if(session % 2) {
      log(request, session, "random");
      const a=getRandomFood();
      const b=getRandomFood(a);
      response.json({"searchSession":session,"a":IMAGES[a],"b":IMAGES[b]});
    } else {
      log(request, session, "stratified");
      const a=getRandomStratifiedFood();
      const b=getRandomStratifiedFood(a);
      response.json({"searchSession":session,"a":STRATIFIED[a[0]][a[1]],"b":STRATIFIED[b[0]][b[1]]});
    }
  });
});


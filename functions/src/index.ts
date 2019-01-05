import * as functions from 'firebase-functions';
import { Request, Response } from 'express';
//import * as cors from 'cors';
import { IMAGES } from './images';

// Start writing Firebase Functions
// https://firebase.google.com/docs/functions/typescript
//const corsHandler = cors({origin: true});
const cors = require('cors')({origin: true});

function getSession(): number {
  return Math.floor(Math.random() * 2147483647);
}
function getRandomFood(otherThan?: number): number {
  let food = Math.floor(Math.random() * IMAGES.length);    
  while(food === otherThan) {
    food = Math.floor(Math.random() * IMAGES.length);
  }
  return food;
}
function log(request: Request, session: number): void {
  console.log(`${request.ip} ${session} "${request.url}" "${request.headers["user-agent"]}" ${new Date().getTime()}`);
}
export const hunger = functions.https.onRequest((request: Request, response: Response) => {
  cors(request, response, () => {
    let session: number = request.query.searchSession;
    if (!session) {
      session = getSession(); 
    }
    log(request, session);
    const a=getRandomFood();
    const b=getRandomFood(a);
    response.json({"searchSession":session,"a":IMAGES[a],"b":IMAGES[b]});
  });
});


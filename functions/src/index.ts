import * as functions from 'firebase-functions';
//import * as cors from 'cors';
import { IMAGES } from './images';

// Start writing Firebase Functions
// https://firebase.google.com/docs/functions/typescript
//const corsHandler = cors({origin: true});
const cors = require('cors')({origin: true});

function getSession(): number {
  return Math.floor(Math.random() * 2147483647);
}
function getRandomFood(): number {
  return Math.floor(Math.random() * IMAGES.length);
}
export const hunger = functions.https.onRequest((request, response) => {
  cors(request, response, () => {
    console.log(request.url);
    let session: number = request.query.searchSession;
    if (session == null) {
      console.log("assigning a new session");
      session = getSession(); 
    }
    const a=getRandomFood();
    const b=getRandomFood();
    response.json({"searchSession":session,"a":IMAGES[a],"b":IMAGES[b]});
  });
});


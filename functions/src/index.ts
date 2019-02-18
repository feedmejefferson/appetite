import * as functions from 'firebase-functions';
import { Request, Response } from 'express';
//import * as cors from 'cors';

const cors = require('cors')({origin: true});
export const appetite = functions.https.onRequest((request: Request, response: Response) => {
  cors(request, response, () => {
    console.log(`${request.ip} "${request.headers['user-agent']}" ${JSON.stringify(request.body)}`);
    response.json("thankyou!");
  });
});


import * as functions from 'firebase-functions';
import { Request, Response } from 'express';
import * as crypto from 'crypto';
//import * as cors from 'cors';

const cors = require('cors')({origin: true});
export const appetite = functions.https.onRequest((request: Request, response: Response) => {
  cors(request, response, () => {
    const segment = crypto.createHash('md5').update(`${request.ip} "${request.headers['user-agent']}"`).digest("hex").substr(0,5);
    console.log(`${segment} ${JSON.stringify(request.body)}`);
    response.json("thankyou!");
  });
});


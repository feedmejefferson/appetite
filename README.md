## Hunger (v3) a.k.a. Appetite

Hunger (aka Appetite) is a super simple webservice that collects and logs food viewing sessions as appetite vectors.

### V3 Redesign and Motivations

Earlier versions of the hunger webservice are still available in this repository's history. Initially the hunger api actually proposed which food images the Feed Me Jefferson site would display, so the requirements were more involved and central to the site. Now all of that logic has been ported over to javascript that runs on the client side, so appetite is really only responsible for collecting user journeys -- which we wouldn't otherwise be able to analyze and feed back into the foodspace map.

V1 was implemented as a java based dropwizard microservice. It was built with maven and then wrapped up in a docker image and deployed to an AWS EC2 micro instance (the kind that is part of the free tier for the first year of new AWS accounts). 

As we came to the end of our first year on AWS and after exploring some other options we decided to try going _serverless_ with Google's Firebase Cloud functions. I had considered some other serverless options including AWS Lambda and looked into sticking with java using `fn`, graalvm and substrate, but in the end, for completely unrelated reasons I found myself needing to get up to speed on Javascript, Angular, Ionic and Firebase. 

V2 was just a short term bridge that ported a fully backward compatible version of V1 over to free google hosting via a serverless firebase function. It was only needed until the site itself was upgraded to Angular and all of the hunger logic was integrated into the client side javascript. 


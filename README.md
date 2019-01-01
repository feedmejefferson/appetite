## Hunger (v2)

Hunger is a simple webservice that proposes a sequence of food choices. Each choice includes two food options and as a hungry user selects which of the two options looks better to them, the intent is that each successive set of options will get closer to what the hungry person is hungry for. 

_At least that's the intent_... Currently it just shows random food in an effort to gather data to map out the food to provide better proposals.

### V2 Redesign and Motivations

The original version of the hunger webservice was implemented as a java based dropwizard microservice. It was built with maven and then wrapped up in a docker image and deployed to an AWS EC2 micro instance (the kind that is part of the free tier for the first year of new AWS accounts). 

We're coming up to the end of our first year on AWS and after exploring some other options I've decided to try going _serverless_ with Google's Firebase Cloud functions. I've considered some other serverless options including AWS Lambda and I looked into sticking with java using `fn`, graalvm and substrate, but in the end, for completely unrelated reasons I've found myself needing to get up to speed on Javascript, Angular, Ionic and Firebase. 

Feedme is simply becoming my testbed for those new tools and I'm sure this is going to get ugly...

### Development/Design Goals

As the javascript world and all of it's conventions are largely new and foreign to me, there are a few general _engineering_ best practices that I'd like to try to maintain from my previous life. 

* separate environments
    1. dev (local development)
    2. staging (remote, but not production, somewhat optional, but ideally included)
    3. production
* minimization of workspace dependencies -- I've noticed this a lot so far while getting up to speed in the JS world -- version hell is nothing new, but it seems to be common place to install a lot of packages "globally" on your local environment. I finally came across `npx` the other day which I'm hoping to leverage in an effort to avoid that problem.
* automated testing -- both unit and integration (e2e or end to end as they say in this world?) If I can run them as part of the build with travic, all the better.  
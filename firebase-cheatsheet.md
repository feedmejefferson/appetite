# Firebase Cheat Sheet

Just a quick cheat sheet with some common firebase CLI functions. Keep in mind I'll be prefixing most of these with `npx` to avoid any global installations. The projects package.json file should include any necessary tooling so that you don't have to install anything locally/globally on your own environment (aside from npm and node).

## login to your google account

    npx firebase login
    
If you aren't already authenticated this will open a browser window to authenticate with. 
 
## serve locally

from the `functions/` directory of the project, run:

    npm run serve
    
## deploying to `prod`

    npm run deploy

> what ever happened to teting/staging? 


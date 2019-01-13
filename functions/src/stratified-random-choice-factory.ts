import { Choice, ChoiceFactory } from './choice';
import { getRandomIndex } from './util';

export class StratifiedRandomChoiceFactory implements ChoiceFactory {
  constructor(public cafeteria: string[][]) {}

  newChoice(): Choice {
    const choice = new Choice();
    const strata: number = getRandomIndex(this.cafeteria.length); 
    const indexA = getRandomIndex(this.cafeteria[strata].length);    
    choice.a = this.cafeteria[strata][indexA];
    let indexB = getRandomIndex(this.cafeteria[strata].length);
    while(indexB === indexA) {
      indexB = getRandomIndex(this.cafeteria[strata].length);
    }
    choice.b = this.cafeteria[strata][indexB];
    return choice;
  }
}

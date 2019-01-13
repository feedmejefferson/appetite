import { Choice, ChoiceFactory } from './choice';
import { getRandomIndex } from './util';

export class RandomChoiceFactory implements ChoiceFactory {
  constructor(public cafeteria: string[]) {}

  newChoice(): Choice {
    const choice = new Choice();
    const indexA = getRandomIndex(this.cafeteria.length);    
    choice.a = this.cafeteria[indexA];
    let indexB = getRandomIndex(this.cafeteria.length);
    while(indexB === indexA) {
      indexB = getRandomIndex(this.cafeteria.length);
    }
    choice.b = this.cafeteria[indexB];
    return choice;
  }
}

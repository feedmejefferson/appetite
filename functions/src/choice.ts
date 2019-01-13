export class Choice {
  a: string;
  b: string;
}

export interface ChoiceFactory {
  newChoice (): Choice;
}

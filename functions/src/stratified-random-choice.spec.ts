import { describe, it } from 'mocha';
import { expect } from 'chai';
import { ChoiceFactory } from './choice';
import { StratifiedRandomChoiceFactory } from './stratified-random-choice-factory';

describe('New Stratified Random Choice', function() {
  const factory: ChoiceFactory = new StratifiedRandomChoiceFactory([["1st", "2nd"],["3rd","4th"]]);
  it('should not ever propose two of the same thing', function() {
    for(let i=0;i<10;i++) {
      const choice = factory.newChoice();
      expect(choice.a).to.be.a('string');
      expect(choice.b).to.be.a('string');
      expect(choice.a).to.not.equal(choice.b);
    }  
  });

  it('should not always propose the same options', function() {
    this.retries(10);   
    const choice = factory.newChoice();
    const anotherChoice = factory.newChoice();
    expect(choice.a).not.to.equal(anotherChoice.a);
    //console.log("trying again");
  });
});

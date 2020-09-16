package labs_examples.enumerations.labs;

/**
 * Enumerations Exercise 1:
 *
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a seperate class.
 *      2) Create a parameterized enumeration that passes one or more values to it's constructor. Demonstrate the use
 *      of this enum from a seperate class.
 */


class Controller {
    public static void main(String[] args) {
        MusicalPhrase phraes1 = new MusicalPhrase();
        MusicalPhrase phrase2 = new MusicalPhrase(Dynamic.P, PhraseFunction.CONSEQUENT, TuningSystem.JUST_INTONATION);

    }
}

enum Dynamic {
    P, MP, MF, F, FF
}

enum PhraseFunction {
    ANTECEDENT, CONSEQUENT
}

enum TuningSystem {
    EQUAL_TEMPERAMENT, JUST_INTONATION('C'), QUARTER_COMMA_MEANTONE('G');
    char key;

    TuningSystem(){}
    TuningSystem(char key) {
        this.key = key;
    }
}

class MusicalPhrase {
    Dynamic dynamic;
    PhraseFunction phraseFunction;
    TuningSystem tuningSystem;

    public MusicalPhrase(){
        this.dynamic = Dynamic.MF;
        this.phraseFunction = PhraseFunction.ANTECEDENT;
        this.tuningSystem = TuningSystem.EQUAL_TEMPERAMENT;
    }
    public MusicalPhrase(Dynamic dynamic, PhraseFunction phraseFunction, TuningSystem tuningSystem){
        this.dynamic = dynamic;
        this.phraseFunction = phraseFunction;
        this.tuningSystem = tuningSystem;
    }
}
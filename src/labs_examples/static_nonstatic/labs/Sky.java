package labs_examples.static_nonstatic.labs;

public class Sky {

    public static void rain(){
        System.out.println("but it starts to rain");
    }

    public void flood(){
        System.out.println("and the rain triggers a flood");
        destruction();
    }

    public void destruction(){
        System.out.println("which wipes out the whole SE side");
        Earth earth1 = new Earth();
        earth1.house();
        thoughts();
        Earth.moreThoughts();
    }

    public static void thoughts(){
        System.out.println("Many Mother Natures are at war.");
    }

}

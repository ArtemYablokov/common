package main.java;

public abstract class AbstractVsInterface {
    protected String value;

    public abstract String getVal();


    public static void main(String[] args) {
        GetSimple getSimple = new GetSimple();
        System.out.println(getSimple.getVal());
        GetDifficukt getDifficukt = new GetDifficukt();
        System.out.println(getDifficukt.getVal());
        System.out.println(getSimple.getVal());

    }
}

class GetSimple extends AbstractVsInterface{

    public GetSimple() {
        value = "Simple";
    }

    @Override
    public String getVal() {
        return value;
    }
}

class GetDifficukt extends AbstractVsInterface{
    public GetDifficukt() {
        value = "Difficult";
    }

    @Override
    public String getVal() {
        return value;
    }
}



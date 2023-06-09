package pl.sda.javapol141.task08;

public class MyValidator implements Validator{
    @Override
    public boolean validate(Parcel input) {
        if (input.getXLength() < 30){
            return false;
        }
        if (input.getYLength() < 30){
            return false;
        }
        if (input.getZLength() < 30){
            return false;
        }
        if (input.getXLength() + input.getYLength() + input.getZLength() > 300){
            return false;
        }
        if (!input.isExpress() && input.getWeight() > 30){
            return false;
        }
        if (input.isExpress() && input.getWeight() > 15){
            return false;
        }
        return true;
    }
}

package Part_1;

public class AutoManager implements AutoReg{
    @Override
    public Cars cars(Cars car) {
        return car;
    }

    @Override
    public Motorbikes motorbikes(Motorbikes motorbike) {
        return motorbike;
    }


}

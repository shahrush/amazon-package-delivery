import java.util.*;


public class DataLoader implements IDataLoader{

    public List<String> GetData(){

        ArrayList<String> Data = new ArrayList<>();

        Data.add("{{\"Size\":\"Large\"},{\"Fragile\":\"false\"},{\"SendDate\":\"12/12/2018 3:00pm\"},{\"Prime\":\"true\"}" +
                ",{\"NextCity\":\"Boston\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"18 lbs\"}}");

        Data.add("{{\"Size\":\"Large\"},{\"Fragile\":\"false\"},{\"SendDate\":\"12/12/2018 3:00pm\"},{\"Prime\":\"false\"}," +
                "{\"NextCity\":\"Boston\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"100 lbs\"}}");


        Data.add("{{\"Size\":\"Small\"},{\"Fragile\":\"false\"},{\"SendDate\":\"12/12/2018 2:59pm\"},{\"Prime\":\"true\"},{" +
                "\"NextCity\":\"Burlington\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"5 lbs\"}}");

        Data.add("{{\"Size\":\"\"},{\"Fragile\":\"true\"},{\"SendDate\":\"12/15/2018 11:53am\"},{\"Prime\":\"false\"}," +
                "{\"NextCity\":\"Portland\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"\"}}");

        Data.add("{{\"Size\":\"Large\"},{\"Fragile\":\"false\"},{\"SendDate\":\"11/23/2018 3:34pm\"},{\"Prime\":\"true\"}," +
                "{\"NextCity\":\"Phoenix\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"15 lbs\"}}");

        Data.add("{{\"Size\":\"Medium\"},{\"Fragile\":\"true\"},{\"SendDate\":\"12/10/2018 3:00pm\"},{\"Prime\":\"false\"}," +
                "{\"NextCity\":\"New York\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"33 lbs\"}}");

        Data.add("{{\"Size\":\"XL\"},{\"Fragile\":\"true\"},{\"SendDate\":\"12/10/2018 1:00am\"},{\"Prime\":\"false\"}," +
                "{\"NextCity\":\"\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"70 lbs\"}}");

        Data.add("{{\"Size\":\"Medium\"},{\"Fragile\":\"false\"},{\"SendDate\":\"12/10/2018 3:00pm\"},{\"Prime\":\"false\"}," +
                "{\"NextCity\":\"Nashville\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"14 lbs\"}}");

        Data.add("{{\"Size\":\"Small\"},{\"Fragile\":\"false\"},{\"SendDate\":\"12/24/2018 7:00pm\"},{\"Prime\":\"false\"}," +
                "{\"NextCity\":\"New Brunswick\"},{\"Origin\":\"Seattle\"},{\"Weight\":\" 1.5 lbs\"}}");

        Data.add("{{\"Size\":\"XL\"},{\"Fragile\":\"false\"},{\"SendDate\":\"1/1/2019 11:00am\"},{\"Prime\":\"\"}," +
                "{\"NextCity\":\"Wayne\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"30 lbs\"}}");

        Data.add("{{\"Size\":\"\"},{\"Fragile\":\"false\"},{\"SendDate\":\"11/23/2018 4:00pm\"},{\"Prime\":\"false\"}," +
                "{\"NextCity\":\"New York\"},{\"Origin\":\"Seattle\"},{\"Weight\":\"\"}}");

        return Data;
    }
}
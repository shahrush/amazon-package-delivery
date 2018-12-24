import java.util.*;
import java.util.stream.Collectors;


public class Main extends DataLoader {


    private static List<List<String>> preProcessingData(List<String> data){

        List<String> packages = data.stream().map(s-> s.replaceAll("\\{}", "").
                replaceAll("}", "").replaceAll("\"", "")).collect(Collectors.toList());

        return packages.stream().map(s -> Arrays.asList(s.split(","))).collect(Collectors.toList());
    }

    private static boolean isEmptyValue(List<String> entry){
        for(String e:entry){
            if(e.split(":").length<2){
                return true;
            }
        }
        
        return false;
    }

    private static List<PackageClass> segregateFragilePackages(List<PackageClass> packageClassList){

        List<PackageClass> fragilePackages = new ArrayList<>();
        for (int i = 0 ; i < packageClassList.size(); i++){
            if(packageClassList.get(i).isFragile()){
                fragilePackages.add(packageClassList.get(i));
            }
        }

        return fragilePackages;
    }

    private static List<PackageClass> segregateExpeditedPackages(List<PackageClass> packageClassList){

        List<PackageClass> expeditedPackages = new ArrayList<>();

        Date currentDate = new Date();

        for (int i = 0 ; i < packageClassList.size(); i++){
            Date futureDate = packageClassList.get(i).getSendDate();
            int diffInDays = (int)( (futureDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24) );
            if(diffInDays < 2){
                expeditedPackages.add(packageClassList.get(i));
            }
        }

        return expeditedPackages;
    }

    public static void main(String[] args) throws Exception {

        DataLoader d = new DataLoader();
        List<String> data = d.GetData();
        List<PackageClass> packageClassList = new ArrayList<>();
        List<PackageClass> fragilePackages;
        List<PackageClass> expeditedPackages;
        List<PackageClass> normalPackages;
        List<List<String>> attributes;

        attributes = preProcessingData(data);

        for(List<String> attribute: attributes) {

            if (!isEmptyValue(attribute)){
                packageClassList.add(new PackageClass(attribute));
            }
        }

        fragilePackages = segregateFragilePackages(packageClassList);

        expeditedPackages = segregateExpeditedPackages(packageClassList);

    }
}

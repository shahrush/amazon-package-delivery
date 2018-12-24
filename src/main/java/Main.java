import java.util.*;
import java.util.stream.Collectors;


public class Main extends DataLoader {


    private static List<List<String>> preProcessingData(List<String> data){

        List<String> packages = data.stream().map(s-> s.replaceAll("\\{}", "").
                replaceAll("}", "").replaceAll("\"", "")).collect(Collectors.toList());

        List<List<String>> attributes = packages.stream().map(s -> Arrays.asList(s.split(","))).collect(Collectors.toList());

        return attributes;
    }

    private static boolean isEmptyValue(List<String> entry){
        for(String e:entry){
            if(e.split(":").length<2){
                return true;
            }
        }
        return false;
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



}

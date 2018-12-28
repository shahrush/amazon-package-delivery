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

    private static List<PackageClass> segregateNormalPackages(List<PackageClass> packageClassList){

        Date currentDate = new Date();

        List<PackageClass> normalPackages = new ArrayList<>();
        for (int i = 0 ; i < packageClassList.size(); i++){
            Date futureDate = packageClassList.get(i).getSendDate();
            int diffInDays = (int)( (futureDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24) );
            if(!packageClassList.get(i).isFragile() && diffInDays > 2){
                normalPackages.add(packageClassList.get(i));
            }
        }

        return normalPackages;
    }

    private static void sortPackages(List<PackageClass> packageClassList){

        Collections.sort(packageClassList, Comparator.comparing(PackageClass::getSendDate)
                .thenComparing(PackageClass::getSizePriority)
                .thenComparing((PackageClass p)->!p.isPrime()));

        System.out.println("           Send Date        " + " | " + " Size " + " |" + "Prime" + " | " + "Fragile " + " | " + "   To   " + "   | " + "   From   " + " | " + "Weight    " );

        for(PackageClass amazonPackage: packageClassList){
            System.out.println(amazonPackage.getSendDate() + " | " + amazonPackage.getSize() + " |" + amazonPackage.isPrime()
                    + " | " + amazonPackage.isFragile() + "     |    " + amazonPackage.getNextCity() + " |   " + amazonPackage.getOrigin()
                    + "  | "  + amazonPackage.getWeight());
        }
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

        normalPackages = segregateNormalPackages(packageClassList);



    }
}

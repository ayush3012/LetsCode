package InterviewProgramming.com.example.tricky;

import java.util.Arrays;
import java.util.List;

public class AsListVSOf {

    public static void main(String[] args) {
        String[] arr={"java","python"};
        List<String> al= Arrays.asList(arr); // this will print [cpp,python]-> arr and al reference same and
                                              // al is mutable
        //List<String> al=List.of(arr);       // this will print [java,python]-> List.of returns immutable object

        arr[0]="cpp";

        System.out.println(al.hashCode()+" "+arr.hashCode());
    }
}

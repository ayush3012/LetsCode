package DailyCheck.com.MyPack.Misc;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student{
    int id;
    String name;
    //Address address: if class has mutable fields like this then we should exclude from hashcode and equals

    Student(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id,name);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(Objects.isNull(obj))
             return false;
        if(!(obj instanceof Student))
            return false;
        Student s=(Student)obj;
        return this.id==s.id && this.name.equals(s.name);
    }
}
public class ObjectAsKey {

    public static void main(String[] args) {

        Set<Student> hs=new HashSet<>();

        Student s1=new Student(1000,"A");
        Student s2=new Student(1000,"A");

        hs.add(s1);
        hs.add(s2);

        System.out.println("size of set:"+hs.size());

        System.out.println("hashcode of s1:"+s1.hashCode());

        System.out.println("hashcode of s2:"+s2.hashCode());

        System.out.println("equality check:"+s1.equals(s2));
    }
}
/**
 * ===========SCENARIO: If we don't override hashcode and equals===============
 *
 * hashcode(): default implementation will give integer based on reference of s1 and s2.
 *             so both will be unequal
 *
 * equals(Object obj):default implementation will compare reference like obj==this
 *
 *  Conclusion: since reference is different so hashcode will be different and equals will be false.
 *
 *  SO, SIZE OF SET WILL BE 2.
 *
 *
 * ===========SCENARIO: If we override hashcode and equals===============
 *
 * hashcode(): if we override hashcode as above.
 *            Objects.hash(...)  will delegates call to Arrays.hashCode(new Object[]{id,name})
 *
 *            which has implementation like:
 *
 *            int result=1;
 *            for(Object element:array)
 *              result=31*result+(element==null?0:elements.hashCode());
 *
 *        So, it will calculate hashcode based on Id and name : which will be same if both are same;
 *
 *        NOTE: we can also decide specific attribute to get hashcode instead of every attribute
 *  *
 *  * equals(Object obj): equals will also check if every attribute is same as per implementation.
 *  *
 *  *  Conclusion: since hashcode will be calculated same and equals will also be true in this case.
 *  *
 *  *  SO, SIZE OF SET WILL BE 1.
 * ======================HASHCODE and EQUALS CONTRACT==================
 *
 * while implementing hashcode and equals we should adhere to hashcode and equals contract.
 *
 *    obj1.hashCode()==obj2.hashCode():  object may or may name be same (hashcode is just a mathematical
 *                                       calculation which can be same for two different object,
 *                                       it is just used to identify bucket it will be placed after modulus)
 *   obj1.equals(obj2): object must be same and its hashcode must be equal.
 * */
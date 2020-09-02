/**
 *
 *  @author Piątkowski Marcin S16425
 *
 */

package zad1;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" ); 
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector sel = new Selector<Boolean>() {
				@Override
				public boolean select(Object t) {
					return (Integer) t < 10 ? true : false;
				}

				
    };
    
    Mapper map =new Mapper<Integer,Integer>() {
    			@Override
    			public Integer map( Integer t) {
    				return t+=10;
    			}	
    };   	
    
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  
}
 
 
public List<Integer> test2(List<String> src) {
    Selector sel = new Selector<Boolean>() {
		@Override
		public boolean select(Object t) {
			// TODO Auto-generated method stub
			if(t.toString().length() > 3) {
			return true;
		}else {
			return false;
		}
		}
    };
    
    Mapper map = new Mapper<String,Integer>() {
		@Override
		public Integer map(String v) {
			// TODO Auto-generated method stub
			return v.length()+10;
		}
    };
    
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
}


public static void main(String[] args) {
    new Main();
  }
}

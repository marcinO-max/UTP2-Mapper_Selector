/**
 *
 *  @author Piątkowski Marcin S16425
 *
 */

package zad1;

import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> { 
	List <T> list;
	List <T> listTmp;
	
	public ListCreator(List <T> lista) {
		this.list = lista;
	}
	
	public static <T> ListCreator<T> collectFrom(List<T> list){
		ListCreator<T> probka = new ListCreator<>(list);
		return probka;
	}
	
	public ListCreator<T> when(Selector<T> sel) {
		listTmp = new ArrayList<T>();
		
		for(int i = 0 ; i <list.size();i++) { 
			if(sel.select(list.get(i))) {
				listTmp.add(list.get(i));
			}
		}

		this.list=listTmp;
		return this;
	}
	
	public List<T> mapEvery(Mapper map) {
		listTmp = new ArrayList<T>();
		for(T t : list) {
			listTmp.add((T)map.map(t));
		}
		this.list = listTmp;		
		return list;
	}
}  

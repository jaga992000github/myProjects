package search_interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public interface  BFS<T> {
	
	private void mapLevel(int level,T current,HashMap<Integer,ArrayList<T>> level_map) {
		ArrayList<T> level_list=level_map.get(level);
		if(level_list==null) {
			level_list=new ArrayList<T>();
			level_map.put(level, level_list);
			level_list=level_map.get(level);
		}
		level_list.add(current);
	}
	
	
	private int performLevelMap(T start,T end, HashMap<Integer, ArrayList<T>> level_map, Queue<T> q) {
		T current=q.peek();
//		System.out.println(current);
		ArrayList<T> near= getNearByObj(current);
		int current_height=getHeight(current);
		for(T obj:near) {
			if(obj.equals(end)) {
				q.clear();
				ArrayList<T> map_list=new ArrayList<T>();
				map_list.add(obj);
				level_map.put(current_height+1, map_list);
				return current_height;
			}
			else if(!q.contains(obj)&&!getIsVisited(obj)) {
				q.add(obj);
				if(!getIsVisited(obj)) {
					if(level_map.get(current_height+1)==null) {
						ArrayList<T> map_list=new ArrayList<T>();
						level_map.put(current_height+1, map_list);
					}
					setHeight(current_height+1, obj);
					setIsVisited(obj, true);
					level_map.get(current_height+1).add(obj);
				}
			}
//System.out.println(q);
		}
		q.remove(current);
		return performLevelMap(start,end,level_map,q);
	}
	
	
	public default  ArrayList<T> getShortestPath(T start,T end){
		HashMap<Integer,ArrayList<T>> level_map=new HashMap<Integer,ArrayList<T>>();
		Queue<T> q=new LinkedList<T>();
		setHeight(0,start);
		q.add(start);
		mapLevel(0,start, level_map);
		setIsVisited(start, true);
		int search_height=performLevelMap(start,end,level_map,q);
		ArrayList<T> shortest_path=new ArrayList<T>();
		T current=end;
		shortest_path.add(end);
		while(!current.equals(start)&&search_height>=0) {
			ArrayList<T> current_list =level_map.get(search_height);
			for(T i:current_list) {
				if(getNearByObj(current).contains(i)) {
					shortest_path.add(i);
					current=i;
					search_height--;
					break;
				}
			}
		}
		ArrayList<T> temp =  (ArrayList<T>) shortest_path.clone();
		shortest_path.clear();
		for(int i=temp.size()-1;i>=0;i--) {
			shortest_path.add(temp.get(i));
		}
		return shortest_path;
	}
	
	public abstract ArrayList<T>  getNearByObj(T obj);
	public abstract boolean  getIsVisited(T obj);
	public abstract void  setIsVisited(T obj,boolean bool_val);
	public abstract void setHeight(int high,T obj);
	public abstract int getHeight(T obj);
}

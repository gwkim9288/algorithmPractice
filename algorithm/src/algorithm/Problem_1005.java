package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_1005 {

    static ArrayList<Building> buildings;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()," ");
            buildings = new ArrayList<>();
            buildings.add(new Building(0));
            ans = 0;

            for(int j=0;j<N;j++){
                buildings.add(new Building(Integer.parseInt(st.nextToken())));
            }
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine()," ");
                int prev = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                buildings.get(next).addPrev(prev);
            }
            st= new StringTokenizer(br.readLine()," ");
            find(Integer.parseInt(st.nextToken()),0);
            System.out.println(ans);
        }

    }

    public static void find(int buildingNum, int cost){
        Building building = buildings.get(buildingNum);
        if(building.prev.isEmpty()){
            ans = Math.max(ans,cost+building.cost);
            return;
        }
        for(int i=0;i<building.prev.size();i++){
            find(building.prev.get(i),cost+building.cost);
        }
    }
}

class Building{
    int cost;
    ArrayList<Integer> prev = new ArrayList<>();
    Building(int cost){
        this.cost = cost;
    }

    void addPrev(int num){
        prev.add(num);
    }
}

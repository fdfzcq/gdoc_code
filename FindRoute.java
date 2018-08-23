import java.util.*;
class FindRoute{
  public static void main(String[] args){
    runTestCase1(); //empty graph
    runTestCase2(); //no route
    runTestCase3(); //has route
  }

  public static void runTestCase1(){
    System.out.println("Run Test Case 1: when the graph is empty");
    Graph g = new Graph();
    g.findRoute(1,2);
  }

  public static void runTestCase2(){
    System.out.println("Run Test Case 2: when there is no route");
    Graph g = new Graph();
    for(int i=1;i<5;i++){ g.addVertex(i); }
    g.directedConnect(1,3);
    g.directedConnect(2,4);
    g.directedConnect(2,1);
    g.findRoute(1,2);
  }

  public static void runTestCase3(){
    System.out.println("Run Test Case 3: when there is a route");
    Graph g = new Graph();
    for(int i=1;i<10;i++){ g.addVertex(i); }
    g.directedConnect(8,2);
    g.directedConnect(2,8);
    g.directedConnect(1,10);
    g.directedConnect(1,5);
    g.directedConnect(10,9);
    g.directedConnect(10,8);
    g.findRoute(1,2);
  }

  static class Graph{
    Set<Vertex> vertexes;
    Set<Edge> directedEdges;
    
    public Graph(){
      this.vertexes = new HashSet<Vertex>();
      this.directedEdges = new HashSet<Edge>();
    }

    void addVertex(int n){
      Vertex v = new Vertex(n);
      this.vertexes.add(v);
    }

    void directedConnect(int n1, int n2){
      Edge e = new Edge(n1, n2);
      this.directedEdges.add(e);
    }

    void findRoute(int start, int end){
      if(this.vertexes.size() == 0){
        System.out.println("No Route");
      } else {
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        StringBuilder route = new StringBuilder();
        System.out.println(findRoute(start, end, visited, route));
      }
    }

    String findRoute(int start, int end, HashMap<Integer,Integer> visited, StringBuilder route){
      if(start == end){
        if(route.length() == 0){
          return "No Route";
        } else {
          route.append(start);
          return route.toString();
        }
      }
      if(visited.containsKey(start)){ return "No Route"; }
      for(Edge e:this.directedEdges){
        if(e.vFrom == start){
          visited.put(start,1);
          route.append(start);
          route.append("->");
          String res =
            findRoute(e.vTo, end, visited, route);
          if(!res.toString().equals("No Route")){ return res; }
        }
      }
      return "No Route";
    }
  }

  static class Vertex{
    int value;
    public Vertex(int value){ this.value = value; }
  }

  static class Edge{
    int vFrom;
    int vTo;
    public Edge(int vf, int vt){
      this.vFrom = vf;
      this.vTo = vt;
    }
  }
}

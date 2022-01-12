import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    /** 边 */
    static class Edge{
        /** 权重 */
        int weight;
        /** 出度指向的点 */
        int toVertex;
        Edge next;
        public Edge(int weight, int toVertex, Edge next) {
            this.weight = weight;
            this.toVertex = toVertex;
            this.next = next;
        }
    }
    /** 顶点 */
    static class Vertex{
        /** 入度 数量 */
        int inNumber;
        /** 顶点信息 */
        Character data;
        /** 第一条边 */
        Edge firstEdge;

        public Vertex(int inNumber, Character data, Edge firstEdge) {
            this.inNumber = inNumber;
            this.data = data;
            this.firstEdge = firstEdge;
        }
    }
    /** 拓扑排序 */
    public static boolean topological(List<Vertex> graph){
        // 输出顶点的个数
        int outVertices = 0;
        // 栈：用来储存入度个数为 0 的顶点
        Stack<Vertex> stack = new Stack<>();
        //将顶点入度个数为 0 的元素入栈
        for (Vertex vertex : graph) {
            if (vertex.inNumber == 0) {
                stack.push(vertex);
            }
        }
        // 直到 AOV 网中不存在入度为 0 的点
        while (!stack.empty()){
            // 弹出顶点
            Vertex pop = stack.pop();
            // 输出弹出的顶点
            System.out.println(pop.data);
            // 统计输出个数
            outVertices ++;
            //遍历这个点的出度
            Edge outEdge = pop.firstEdge;
            while (outEdge!=null){
                //出度的目标入度减少
                Vertex toVertex = graph.get(outEdge.toVertex);
                toVertex.inNumber --;
                //目标减少后 入度为 0 就入栈
                if (toVertex.inNumber == 0){
                    stack.push(toVertex);
                }
                outEdge = outEdge.next;
            }

        }
        // 输出所有点才返回 true.
        if (outVertices == graph.size()){
            return true;
        }
        return false;
    }
    /** 测试 */
    public static void main(String[] args) {
        //构建图 A -> B -> C
        ArrayList<Vertex> graph = new ArrayList<>();
        //环 测试
//        Edge edge1 = new Edge(10, 1,null);
//        Edge edge2 = new Edge(10, 2,null);
//        Edge edge3 = new Edge(10, 0,null);
//        Vertex a = new Vertex(1, 'A', edge1);
//        Vertex b = new Vertex(1, 'B', edge2);
//        Vertex c = new Vertex(1, 'C', edge3);
        //无环 测试
        Edge edge1 = new Edge(10, 1,null);
        Edge edge2 = new Edge(10, 2,null);
        Vertex a = new Vertex(0, 'A', edge1);
        Vertex b = new Vertex(1, 'B', edge2);
        Vertex c = new Vertex(1, 'C', null);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        //判断是否拓扑
        System.out.println(topological(graph));
    }
}


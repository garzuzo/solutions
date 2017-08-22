
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
	public static int combinacion(Node n1, Node n2) {

		int suma = 0;
		if (n1 != null && n1.getColor().equals(QuadTree.BLACK)) {
			return 1024 / n1.getDivPixels();

		} else if (n2 != null && n2.getColor().equals(QuadTree.BLACK)) {
			return 1024 / n2.getDivPixels();
		} else if (n1 != null && n1.getColor().equals(QuadTree.GRAY) && n2 != null
				&& n2.getColor().equals(QuadTree.GRAY)) {
			suma += combinacion(n1.getFirst(), n2.getFirst());
			suma += combinacion(n1.getSecond(), n2.getSecond());
			suma += combinacion(n1.getThird(), n2.getThird());
			suma += combinacion(n1.getFourth(), n2.getFourth());

		} else if (n1 != null && n1.getColor().equals(QuadTree.GRAY)) {
			suma += combinacion(n1.getFirst(), n2.getFirst());
			suma += combinacion(n1.getSecond(), n2.getSecond());
			suma += combinacion(n1.getThird(), n2.getThird());
			suma += combinacion(n1.getFourth(), n2.getFourth());

		} else if (n2 != null && n2.getColor().equals(QuadTree.GRAY)) {
			suma += combinacion(n1.getFirst(), n2.getFirst());
			suma += combinacion(n1.getSecond(), n2.getSecond());
			suma += combinacion(n1.getThird(), n2.getThird());
			suma += combinacion(n1.getFourth(), n2.getFourth());
		}

		return suma;
	}

	public static class QuadTree {

		private Node root;
		public static final String BLACK = "f";
		public static final String WHITE = "e";
		public static final String GRAY = "p";

		public QuadTree() {

			root = null;
		}

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}

		public void add(Node x) {

			if (root == null) {
				root = x;
			} else {
				root.add(root, x, false);
			}
		}

		public int contarPixeles() {

			return root.contarPix(root);
		}

		public QuadTree combinar(QuadTree qt1, QuadTree qt2) {

			return qt1;
		}

	}

	public static class Node {

		private Node first, second, third, fourth;
		private String color;
		private int divPixels;
		private Node parent;

		public Node() {

			color = QuadTree.WHITE;

		}

		public Node(String col) {
			if (col.equals(QuadTree.GRAY)) {
				color = col;
				first = null;
				second = null;
				third = null;
				fourth = null;
				parent = null;
				divPixels = 1;
			} else {
				color = col;
				parent = null;
				divPixels = 1;
			}
		}

		public int contarPix(Node x) {

			if (x.color.equals(QuadTree.BLACK)) {
				return 1024 / x.divPixels;
			} else {
				int sum = 0;
				if (x.first != null)
					sum += contarPix(x.first);
				if (x.second != null)
					sum += contarPix(x.second);
				if (x.third != null)
					sum += contarPix(x.third);
				if (x.fourth != null)
					sum += contarPix(x.fourth);
				return sum;
			}

		}

		public Node getFirst() {
			return first;
		}

		public void setFirst(Node first) {
			this.first = first;
		}

		public Node getSecond() {
			return second;
		}

		public void setSecond(Node second) {
			this.second = second;
		}

		public Node getThird() {
			return third;
		}

		public void setThird(Node third) {
			this.third = third;
		}

		public Node getFourth() {
			return fourth;
		}

		public void setFourth(Node fourth) {
			this.fourth = fourth;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getDivPixels() {
			return divPixels;
		}

		public void setDivPixels(int divPixels) {
			this.divPixels = divPixels;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public boolean add(Node actual, Node x, boolean seAgrego) {

			if (actual.first == null && !seAgrego) {
				actual.first = x;
				x.parent = actual;
				x.divPixels = x.parent.divPixels * 4;
				seAgrego = true;
				return true;
			} else if (actual.first.color.equals(QuadTree.GRAY)) {

				if (add(actual.first, x, seAgrego))
					return true;

			}
			if (actual.second == null && !seAgrego) {
				actual.second = x;
				x.parent = actual;
				x.divPixels = x.parent.divPixels * 4;
				seAgrego = true;
				return true;
			} else if (actual.second.color.equals(QuadTree.GRAY)) {

				if (add(actual.second, x, seAgrego))
					return true;
			}
			if (actual.third == null && !seAgrego) {
				actual.third = x;
				x.parent = actual;
				x.divPixels = x.parent.divPixels * 4;
				seAgrego = true;
				return true;
			} else if (actual.third.color.equals(QuadTree.GRAY)) {
				if (add(actual.third, x, seAgrego))
					return true;
			}
			if (actual.fourth == null && !seAgrego) {
				actual.fourth = x;
				x.parent = actual;
				x.divPixels = x.parent.divPixels * 4;
				seAgrego = true;
				return true;
			} else if (actual.fourth.color.equals(QuadTree.GRAY)) {
				if (add(actual.fourth, x, seAgrego))
					return true;
			}
			return seAgrego;

		}

		public boolean isParent(Node x) {

			return x.color.equals(QuadTree.GRAY);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader lect = new BufferedReader(new InputStreamReader(System.in));

		int casos = Integer.parseInt(lect.readLine());

		while (casos != 0) {
			QuadTree qt = new QuadTree();
			QuadTree qt1 = new QuadTree();
			String arb1 = lect.readLine();
			String arb2 = lect.readLine();

			for (int i = 0; i < arb1.length(); i++) {

				Node x = new Node(arb1.charAt(i) + "");
				qt.add(x);
			}
			for (int i = 0; i < arb2.length(); i++) {
				Node x = new Node(arb2.charAt(i) + "");
				qt1.add(x);
			}
			int resultado = combinacion(qt.getRoot(), qt1.getRoot());

			System.out.println("There are " + resultado + " black pixels.");

			casos--;
		}

	}

}

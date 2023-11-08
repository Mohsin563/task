package midexam;

public class task {
public class node{
	int data;
	node left,right;
	node(int data){
		this.data=data;
		left=null;
		right=null;
		
	}
}
	node root;
	
	public node insert(node root,int data) {
		if(root==null) {
			root=new node(data);
			
			return root;
			
		}
		
		if(root.data<data) {
			root.left=insert(root.left,data);
		}
		if(root.data>data) {
			
			root.right=insert(root.right,data);
		}
		return root;
		
		
		
	}
	public static void inorder(node root) {
		if(root==null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data+"-->");
		inorder(root.right);
	}
	
	public static node inordersuccesor(node root) {
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}
	public boolean search(node root,int key) {
		if(root==null) {
			return false;
		}
		if(root.data==key) {
			return true;
		}
		else if(root.data<key) {
			return search(root.left,key);
		}
		else {
			return search(root.right,key);
		}
	}
	
	public static node delete(node root,int val) {
		
		if(root.data>val) {
			root.left=delete(root.left,val);
		}
		else if(root.data<val) {
			root.right=delete(root.right,val);
		}
		else {
			if(root.left==null && root.right==null) {
				return null;
			}
			if(root.left==null) {
				return root.right;
			}
			
			else if(root.right==null) {
				return root.left;
			}
			node is=inordersuccesor(root.right);
			root.data=is.data;
			root.right=delete(root.right,is.data);
		}
		return root;
	}
public static void main(String args[]) {
	task a=new task();
	node root=null;
root=a.insert(root, 50);	
root=a.insert(root, 45);
root=a.insert(root, 62);
root=a.insert(root, 41);
root=a.insert(root, 23);
root=a.insert(root, 65);
root=a.insert(root, 63);
root=a.insert(root, 25);
a.inorder(root);
System.out.println();
System.out.println(a.search(root, 63));



}
}

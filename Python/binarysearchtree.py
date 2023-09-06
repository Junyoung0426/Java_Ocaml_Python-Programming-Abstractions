class TreeNode:
   
    def __init__(self):
        self.left = None
        self.right = None
        self.value = None
        self.lst = []
        self.count = 0

    def set_value(self, value):
        self.value = value

    def __str__(self):
        return str(self.value)

    def __iter__(self):
        self.inorder(self)
        for val in self.lst:
            if self.count < len(self.lst):
                yield val
                self.count += 1
            else:
                raise StopIteration

    def inorder(self, root):
        if root is None:
            return
        self.inorder(root.left)
        self.lst.append(root.value)
        self.inorder(root.right)
        return self.lst
        
class BinarySearchTree:
    root = None
    name = None

    def __init__(self, name, root):
        self.root = root
        self.name = name

    def add_rec(self,node,value):
        if node.value is None:
            node.set_value(value)
        else:
            if value < node.value:
                if node.left is not None:
                    self.add_rec(node.left, value)
                else:
                    node.left = TreeNode()
                    node.left.set_value(value)
            else:
                if node.right is not None:
                    self.add_rec(node.right, value)
                else:
                    node.right = TreeNode()
                    node.right.set_value(value)

    def add_all(self, *values):
        for value in values:
            self.add_rec(self.root, value)
        
    def __iter__(self):
        return self.root.__iter__()
        
    def __str__(self):
        return "["+self.name+"] " + self.print(self.root)

    def print(self, root):
        if root is None:
            return ""
        elif root.left is not None and root.right is not None:
           return str(root.value) + " " + "L:(" + str(self.print(root.left)) + ")" + " " + "R:(" + str(self.print(root.right)) + ")"
        elif root.left is not None and root.right is None:
           return str(root.value) + " " + "L:(" + str(self.print(root.left)) + ")"
        elif root.left is None and root.right is not None:
            return str(root.value) + " " + "R:(" + str(self.print(root.right)) + ")"
        else:
           return str(root.value) + ""

class Merger:
    def merge(t1, t2):
        iter1 = iter(t1)
        iter2 = iter(t2)
        list=[]
        x = next(iter1)
        y = next(iter2)
        while x is not None or y is not None:
            if x <= y:
                list.append(x)
                try:
                    x = next(iter1)
                except RuntimeError :
                    x = None
            else:
                list.append(y)
                try:
                    y = next(iter2)
                except RuntimeError :
                    y = None

            if x is None and y is not None:
                list.append(y)
                try:
                    y = next(iter2)
                except RuntimeError :
                    y = None

            elif x is not None and y is None:
                list.append(x)
                try:
                    x = next(iter1)
                except RuntimeError:
                    x = None  
        return list

if __name__ == "__main__":
    tree = BinarySearchTree(name="Oak", root=TreeNode())
    tree.add_all(5, 3, 9, 0) # adds the elements in the order 5, 3, 9, and then 0
    print(tree)

    t1 = BinarySearchTree(name="Oak", root=TreeNode())
    t2 = BinarySearchTree(name="Birch", root=TreeNode())
    t1.add_all(5, 3, 9, 0)
    t2.add_all(1, 0, 10, 2, 7)

    print()
    print(t1)
    for x in t1.root:
        print(x)

    print()

    print(t2)
    for x in t2:
        print(x)
    print(Merger.merge(t1, t2))
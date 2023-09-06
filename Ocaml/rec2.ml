type('a,'b) tree = 
  | Leaf of 'a
  | Tree of ('a,'b) node
   and ('a ,'b) node = {
    operator: 'b;
    left : ('a, 'b) tree;
    right: ('a, 'b) tree
   };; 


let rec ops_and_vals tree = match tree with
  |Leaf  x -> ([],[x])
  |Tree {operator = op; left =l ; right= r;} ->
    let (left_ops, left_vals) = ops_and_vals l in
    let (right_ops, right_vals) = ops_and_vals r in
    (op :: left_ops @ right_ops, left_vals @ right_vals);;

    ops_and_vals(Tree {operator = (+); left = Leaf 2; right = Leaf 4;})
    ops_and_vals(Tree {operator = (+); left = (Tree {operator = (-); left = Leaf 5 ; right = Leaf 3}); right = Leaf 2;})


type 'a binary_tree =
	| Empty
	| Node of 'a * 'a binary_tree * 'a binary_tree;;

let rec num_of_leaves tree = match tree with
    | Empty -> 1 
    | Node (_, left, right) -> num_of_leaves left+ num_of_leaves right ;;
  
num_of_leaves Empty;;
num_of_leaves(Node(48,Empty,Empty));;
num_of_leaves(Node("root",Node("leftinnter", Empty,Empty), Node("Right",Empty,Empty))) ;;


let rec get_all_leaves tree = match tree with
    |Empty -> [Empty]
    |Node(_,left,right) -> get_all_leaves left @ get_all_leaves right;;

get_all_leaves Empty;;
get_all_leaves(Node(48,Empty,Empty));;
get_all_leaves(Node("root",Node("leftinnter", Empty,Empty), Node("Right",Empty,Empty))) ;;

type ('a, 'b)tree =
|Leaf of 'a
|Tree of {
    operator : 'b;
    left: ('a,'b) tree;
    right: ('a,'b) tree
}

type 'a binary_tree =
	| Empty
	| Node of 'a * 'a binary_tree * 'a binary_tree;;

let rec num_of_leaves tree = tree match with
    |Empty -> 1
    |Node(_,left,right) -> num_of_leaves left + num_of_leaves right;;
let rec get_all_leaves tree = match tree with
    |Empty -> [Empty]
    |Node(_,left,right) -> num_of_leaves left + num_of_leaves right;;

let rec min_weight edges = 
  let rec helper min_edge edges = match edges with 
  | [] -> min_edge
  | ((_,_,x)as h) ::t -> let (_,_,n)= min_edge in if x<n then helper h t else helper min_edge t in helper("","",max_int) eges 

let rec get_last list = 
    match list with
    |[] -> failwith "Error"
    |[x] -> x
    |h::t -> get_last t
;; 

let rec rem_nth list n =
    match list with
    |[] -> raise(Failure ("empty list"))
    |h::t -> if n =0 then t else h::rem_nth (t) (n-1)
;;

let rev_list list = 
    let rec rev acc list = 
        match list with 
        |[] -> acc
        |h::t -> rev (h :: acc) t in rev [] list
    ;;

let rec min_weight edges = 
    let rec helper min_edge edges = 
        match edges with
        |[] -> []
        |((_,_,x) as h) :: t ->let  ("","",) = min_edge
                              in if x < n then helper h t else helper min_edge t
        in helper ("","",max_int) edges
;; 

List.fold_left(fun((_,_,a) as acc)((_,_,b) as curr) -> if a>b then curr else acc)("","",max_int)

type ('a,'b)tree = 
|Leaf of 'a
|Tree of ('a,'b) node 
    and('a,'b) node = {
    operator : 'b;
    left : ('a,'b)tree;
    right :('a,'b)tree
};;

let rec ops_and_vals tree =
    match tree with 
    | Leaf x ->([],[x])
    |Tree{operator = op; left = l; right =r} ->let(left_ops,left_vals) =ops_and_vals l in 
    let(right_ops,right_vals) = ops_and_vals r in(op::left_ops@right_ops, left_vals@right_vals);;

    
ops_and_vals(Tree {operator = (+); left = Leaf 2; right = Leaf 4;})

ops_and_vals(Tree {operator = (+); left = (Tree {operator = (-); left = Leaf 5 ; right = Leaf 3}); right = Leaf 2;})

type 'a binary_tree =
	| Leaf of 'a
	| Node of 'a * 'a binary_tree * 'a binary_tree;;

let rec num_of_leaves tree = 
    match tree with
    |Empty -> 1;
    |Node(_,left,right) -> num_of_leaves (left) + num_of_leaves (right);;

    let rec get_all_leaves tree = 
        match tree with
        |Empty -> [Empty];
        |Node(_,left,right) -> get_of_leaves (left) @ get_of_leaves (right);;



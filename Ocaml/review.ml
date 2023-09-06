let is_complete  num_of_vertices vertex = if(List.length vertex) = (num_of_vertices-1) then true else false;;
let is help_fun num_of_vertices bool_so vertex = bool_so &&(is_complete num_of_vertices vertex)



let is_help_fun num_of_vertices bool_so vertex = bool_so &&(is_complete num_of_vertices vertex)
let rec is_complete_graph dir_graph = 
List.fold_left (is_help_fun(List.length dir_graph)) true dir_graph;;


let rec contains_before targets pattern deadline = 
  match targets with
  |[] -> false
  |x::xs -> if(x = pattern && deadline>0) then true else
    if(deadline =0) then false else contains_before xs pattern (deadline-1);;

type 'a binary_tree = 
    | Leaf of 'a
    | Node of 'a *'a binary_tree * 'a binary_tree
  ;; 
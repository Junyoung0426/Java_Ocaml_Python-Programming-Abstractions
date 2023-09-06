let rec min_weight edges = 
  let rec helper min_edge edges = match edges with
    | [] -> min_edge
    | ((_,_,x) as h) ::t -> let (_,_, n) = min_edge in 
                            if x < n then helper h t else helper min_edge t
in helper ("","",max_float) edges;; 

min_weight[("a","b",4);("b","c",2);("c","d",3)];;

List.fold_left(fun ((_,_, w1)as acc) ((_,_,w2 )as curr) -> if w2 < w1 then curr else acc )("","", max_int)[("a","b",4);("b","c",2);("c","d",3)];;
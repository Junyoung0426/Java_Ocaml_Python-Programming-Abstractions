(* Number 1 *)
let rec pow x n =  
  match n with
  | 0 -> 1
  | _ -> x * pow (x) (n-1)
;;
  
let rec float_pow x n = 
  if n = 0 then 1.0 else x *. float_pow (x) (n-1);;

(* Number 2 *)
let rec compress list =
  match list with
  | [] -> []
  | [h] -> [h]
  | h::next::t -> let x = compress (next::t) in if h = next then x else h :: x
;;

(* Number 3 *)
let rec remove_if list f = 
  match list with
  | [] -> []
  | h :: t -> if (f h) = false then h :: remove_if (t) (f) else  remove_if (t) (f)
;; 

(* Number 4 *)
let rec slice list i j = 
  if  i >= j then [] 
  else 
    let rec strtFrom list i = 
    match list with 
    | [] ->[]
    | x::xs -> if i = 0 then list  else strtFrom xs (i-1) in 
    let rec rmvFrom list j =
      match list with
      |[] -> []
      |x::xs -> if j = 0 then [] else x :: rmvFrom xs (j-1)  
    in strtFrom (rmvFrom list j )(i)
;; 

(* Number 5 *)
let rec equivs f list =
  let rec equivHelp f2 lst = match lst with
  | [] -> []
  | h :: t -> if (f2 h) then h :: (equivHelp f2 t)
  else (equivHelp f2 t)
  in let rec remove_if list2 f3 = 
  match list2 with
  | [] -> []
  | h3 :: t3 -> if (f3 h3) = false then h3 :: remove_if (t3) (f3) else  remove_if (t3) (f3) 
  in let rec listCompare lst1 lst2 = match lst1 with
  | [] -> lst2
  | h2 :: t2 -> let a = (remove_if lst2 ((=)h2)) in (listCompare t2 a)
  in match list with
  |[] -> [[]]
  | x::xs -> let n = (equivHelp (f x) list) in let m = (listCompare n xs) in
  match m with
  | [] -> [n]
  | hd::tl -> n :: (equivs f m);;
  

(* Number 6 *)
let goldbachpair i = 
  let checkPrime x =
    let rec prime_help k = 
      if k = 1 then true else (x mod k != 0 && prime_help (k - 1))
    in prime_help (x-1)
  in if i mod 2 = 1 then  raise (Failure "Input only even number")
    else let rec prime x y =
            if checkPrime(x) && checkPrime(y) 
              then (x ,y) else prime (x+1)(y-1)
  in prime (2) (i-2)
;;

(* Number 7 *)

let rec equiv_on f g lst = 
  match lst with
  | [] -> true
  | [h] -> if(f h = g h) then true else false
  | x::xs -> if(f x = g x) then equiv_on (f) (g) (xs) else false
;;

(* Number 8 *)
let rec pairwisefilter cmp lst =
  match lst with
  | [] -> []
  | [t] ->[t]
  | h::next::t -> cmp h next :: pairwisefilter cmp t
;;


(* Number 9 *)
let rec polynomial list = fun a->
  let rec pow x n =  
    match n with
    | 0 -> 1
    | _ -> x * pow (x) (n-1)
  in match list with
      | [] -> 0
      | (b,c) ::t -> (b) * (pow (a) (c))+ polynomial (t) a
;;   

(* Number 10 *)

let rec powerset lst = 
  let rec powerser_help f list = 
    match list with
    | [] -> []
    | h :: t -> (f h) :: (powerser_help f t) 
  in match lst with
  | [] -> [[]]
  | h1 :: t1 -> (powerset t1) @ powerser_help (fun x -> h1 :: x) (powerset t1)
;;

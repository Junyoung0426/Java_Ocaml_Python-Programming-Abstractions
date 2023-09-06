let rec last list = match list with
  | [] -> failwith "Error"
  | [x] ->x
  | h::t -> last t;;
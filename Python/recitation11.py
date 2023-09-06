#Q1
def increment_by(i):
    def inner(x):
        return x+i;
    return inner
f = increment_by(5)
print(f(0), f(10), f(20))

#Q2

s = "string"
s = s[::-1] # s[start:end:step]
print(s) 

def multiples(range_,x):
    return list(filter(lambda n : n % x==0, range_))
    # range_.stream().filter()
print(multiples(range(10),2))

def firstChar(lst):
    return list(map(lambda s : s[0], lst))
print(firstChar(["hello", "this","is","Junyoung"]))

#Q3
# Put x = iter([1, 2, 3]) in ternmianl and write next(x), next(x)...
class Series:
    def __init__(self,low,high):
        self.high = high
        self.current = low -1

    def __iter__(self):
        return self
    
    def __next__(self):
        if self.current >=self.high:
            raise StopIteration
        else:
            self.current +=1
            return self.current

print(list(Series(5, 15)))
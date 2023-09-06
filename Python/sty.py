def f():
    x= 42
    def g():
        nonlocal x 
        x = 43
    print(x)
    print("after g")
    g()
    print(x)
  

f()
print(str(x))

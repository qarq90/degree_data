import math
 
p = 5
q = 13
 
n = p*q
print("n =", n)
 
phi = (p-1)*(q-1)
 
e = 7
while(e<phi):
    if (math.gcd(e, phi) == 1):
        break
    else:
        e += 1
 
print("e =", e)
k = 1
d = ((k*phi)+1)/e
print("d =", d)
print(f'Public key: {e, n}')
print(f'Private key: {d, n}')
 
msg = 5
print(f'Original message:{msg}')
 
C = pow(msg, e)
C = math.fmod(C, n)
print(f'Encrypted message: {C}')
 
M = pow(C, d)
M = math.fmod(M, n)
 
print(f'Decrypted message: {M}') 
# rsa_sign_verify.py
from Crypto.PublicKey import RSA
from Crypto.Signature import pkcs1_15
from Crypto.Hash import SHA256

def generate_keys(bits=2048):
    key = RSA.generate(bits)
    private_pem = key.export_key()
    public_pem = key.publickey().export_key()
    return private_pem, public_pem

def sign_message(private_pem: bytes, message: bytes) -> bytes:
    key = RSA.import_key(private_pem)
    h = SHA256.new(message)
    signer = pkcs1_15.new(key)
    signature = signer.sign(h)
    return signature

def verify_signature(public_pem: bytes, message: bytes, signature: bytes) -> bool:
    key = RSA.import_key(public_pem)
    h = SHA256.new(message)
    verifier = pkcs1_15.new(key)
    try:
        verifier.verify(h, signature)
        return True
    except (ValueError, TypeError):
        return False

if __name__ == "__main__":
    message = b"Hello! This is a message to sign with RSA."
    # Generate keys
    priv, pub = generate_keys(2048)
    print("Private key length:", len(priv), "bytes")
    print("Public key length:", len(pub), "bytes")

    # Sign
    sig = sign_message(priv, message)
    print("Signature (hex):", sig.hex())

    # Verify
    ok = verify_signature(pub, message, sig)
    print("Signature valid?", ok)

    # Tampering test
    tampered = b"Hello! This is a tampered message."
    ok2 = verify_signature(pub, tampered, sig)
    print("Signature valid on tampered message?", ok2)

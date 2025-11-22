---
share_link: https://share.note.sx/ccugsy5n#EhTqGU9rpsSGpM7tmh1nzwlLrVZSC9ELjhhOe5banPo
share_updated: 2025-11-13T08:55:57+05:30
---
### Differentiate between Passive and Active Attacks.

| **Basis**      | **Passive Attack**                                                               | **Active Attack**                                                                           |
| -------------- | -------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| **Definition** | Attacks that only monitor or eavesdrop on data transmission without altering it. | Attacks that involve modification, alteration, or disruption of data or network operations. |
| **Objective**  | To obtain information being transmitted.                                         | To change system resources or affect their normal operation.                                |
| **Examples**   | - Eavesdropping- Traffic analysis                                                | - Denial of Service (DoS)- Message modification- Masquerade- Replay attack                  |
| **Impact**     | Compromises **confidentiality** of data.                                         | Compromises **integrity and availability** of data.                                         |
| **Detection**  | Hard to detect as no data is modified.                                           | Easier to detect because the system behavior changes.                                       |
| **Prevention** | Encryption and secure transmission.                                              | Authentication, integrity checks, and firewalls.                                            |

---
### Differentiate between HMAC and CMAC.

|**Feature**|**HMAC (Hash-based Message Authentication Code)**|**CMAC (Cipher-based Message Authentication Code)**|
|---|---|---|
|**Underlying Function**|Uses **hash functions** (like SHA-256, SHA-512).|Uses **block cipher algorithms** (like AES).|
|**Algorithm Basis**|Based on hashing and XOR operations.|Based on block cipher encryption with symmetric keys.|
|**Key Type**|Secret key combined with message via hash.|Secret key used in cipher encryption mode.|
|**Output Size**|Depends on the hash function (e.g., 256 bits for SHA-256).|Depends on the block size (e.g., 128 bits for AES).|
|**Speed**|Generally faster due to lightweight hash operations.|Slightly slower due to block cipher computation.|
|**Security**|Depends on collision resistance of the hash function.|Depends on strength of the block cipher.|
|**Usage**|Common in **TLS, SSL, and IPsec**.|Common in **AES-based secure systems**.|

---
### Differentiate between Virus and Worm.

|**Aspect**|**Virus**|**Worm**|
|---|---|---|
|**Definition**|A malicious program that attaches itself to a host file and spreads when the file is executed.|A self-replicating program that spreads automatically through networks without user action.|
|**Dependency**|Needs a host file or program to propagate.|Independent – can spread on its own.|
|**Propagation Method**|Spreads when infected files are shared or executed.|Spreads via network connections or vulnerabilities.|
|**Replication**|Requires user action to trigger replication.|Replicates automatically without user action.|
|**Damage**|Corrupts or modifies files and system data.|Consumes bandwidth, slows systems, or causes network crashes.|
|**Example**|“ILOVEYOU” virus, “Melissa” virus|“Conficker” worm, “SQL Slammer” worm|

---
### Differentiate between DES and AES encryption algorithms.

|**Feature**|**DES**|**AES**|
|---|---|---|
|**Full form**|Data Encryption Standard|Advanced Encryption Standard|
|**Block size**|64 bits|128 bits|
|**Key size**|56 bits|128/192/256 bits|
|**Rounds**|16|10/12/14|
|**Structure**|Feistel network|Substitution–Permutation network|
|**Security**|Outdated, easily breakable|Highly secure|
|**Speed**|Slower|Faster|
|**Example Use**|Legacy systems|Modern encryption (SSL, VPNs)|

---
### Explain the different block cipher modes of operation.

|**Mode**|**Description**|
|---|---|
|**ECB (Electronic Code Book)**|Encrypts each block independently — simple but insecure.|
|**CBC (Cipher Block Chaining)**|Each block XORed with previous ciphertext block.|
|**CFB (Cipher Feedback)**|Converts block cipher into self-synchronizing stream cipher.|
|**OFB (Output Feedback)**|Turns block cipher into synchronous stream cipher.|
|**CTR (Counter)**|Uses a counter for parallel encryption/decryption.|

---
### Explain various Security Principles in Network Security.

| **Security Principle** | **Description**                                                                                                          | **Techniques**                            |
| ---------------------- | ------------------------------------------------------------------------------------------------------------------------ | ----------------------------------------- |
| **Confidentiality**    | Ensures that data is not disclosed to unauthorized individuals, entities, or processes.                                  | Encryption, ACLs, Traffic Padding         |
| **Integrity**          | Ensures that data has not been altered or destroyed in an unauthorized manner.                                           | Hashing, MACs, Digital Signatures         |
| **Authentication**     | Verifies the identity of a user, system, or entity.                                                                      | Passwords, OTPs, Biometrics, Certificates |
| **Non-Repudiation**    | Prevents an entity from denying having performed a previous action or commitment; provides proof of origin and delivery. | Digital Signatures, Timestamps            |
| **Access Control**     | Restricts and controls access to resources (systems, files, data) based on identity and policy.                          | ACLs, RBAC, Security Tokens               |
| **Availability**       | Ensures that systems and resources are accessible and usable upon demand by an authorized entity.                        | Redundancy, Backups, DoS Protection       |
#!/usr/bin/env python
# coding: utf-8

# In[7]:


import redis

redisClient = redis.StrictRedis(
    host='localhost',
    port=6379)


# In[8]:


value = redisClient.get('foo')
print(value)


# In[14]:


redisClient.sadd("primes", 2, 3, 5, 7)
redisClient.sadd("primes1", 2, 3, 9,0)
print("Is 6 a prime number? {}".format(redisClient.sismember("primes", 8)))
print("Is 7 a prime number? {}".format(redisClient.sismember("primes", 7)))


# In[15]:


redisClient.smembers("primes")


# In[16]:


print(redisClient.sunion("primes","primes1"))
# Find the union of the redis sets and store it in the destination set provided

redisClient.sunionstore("primes2", "primes","primes1")

# Print the members of the new set

print(redisClient.smembers("primes2"))


# In[18]:


print(redisClient.sinter("primes","primes1"))
# Find the union of the redis sets and store it in the destination set provided

redisClient.sinterstore("primes3", "primes","primes1")

# Print the members of the new set

print(redisClient.smembers("primes3"))


# In[19]:


print(redisClient.sdiff("primes","primes1"))
# Find the union of the redis sets and store it in the destination set provided

redisClient.sdiffstore("primes4", "primes","primes1")

# Print the members of the new set

print(redisClient.smembers("primes4"))


# In[20]:


print(redisClient.sdiff("primes1","primes"))
# Find the union of the redis sets and store it in the destination set provided

redisClient.sdiffstore("primes5", "primes1","primes")

# Print the members of the new set

print(redisClient.smembers("primes5"))


# In[ ]:





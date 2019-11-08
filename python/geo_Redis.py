#!/usr/bin/env python
# coding: utf-8

# In[4]:


import redis

redisClient = redis.StrictRedis(
    host='localhost',
    port=6379)

redisClient.geoadd('location', 12.97, 77.59, 'Bangalore')


# In[10]:


redisClient.geoadd('geo',  -98.2012939453125, 26.10626220703125,'Bangalore')


# In[23]:


redisClient.hmset('table',  {'id': 1 ,'college':'nnn' ,'address': 'xn'})


# In[24]:


redisClient.geohash('geo','Bangalore')


# In[25]:


redisClient.geoadd('geo',  -98.2012939453125, 26.15626220703125,'store')


# In[28]:


redisClient.geohash('geo','Bangalore','store')


# In[29]:


redisClient.geodist('geo','Bangalore','store')


# In[36]:


redisClient.georadius('geo',-98.2012939453125, 26.15626220703125,10000)


# In[37]:


redisClient.zrem('geo','store')


# In[ ]:





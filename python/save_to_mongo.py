#!/usr/bin/env python
# coding: utf-8

# In[12]:


from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client['test'] # db name

import datetime
post = {"author": "Mike",
        "text": "My first blog post!",
        "tags": ["mongodb", "python", "pymongo"],
        "date": datetime.datetime.utcnow()}


# In[13]:


posts = db['posts'] # table name
post_id = posts.insert_one(post).inserted_id


# In[14]:


db.list_collection_names()


# In[15]:


db['posts']


# In[20]:


import pprint
pprint.pprint(posts.find({"_id": post_id}))


# In[21]:


posts.count_documents({})


# In[27]:


import pymongo
result = db.profiles.create_index([('user_id', pymongo.ASCENDING)],
                                  unique=True)
user_profiles = [
     {'user_id': 213, 'name': 'Luke'},
     {'user_id': 214, 'name': 'Ziltoid'}]


# In[28]:


result = db.profiles.insert_many(user_profiles)


# In[29]:


sorted(list(db.profiles.index_information()))


# In[30]:


duplicate_profile = {'user_id': 212, 'name': 'Tommy'}


# In[31]:


result = db.profiles.insert_one(duplicate_profile)


# In[ ]:





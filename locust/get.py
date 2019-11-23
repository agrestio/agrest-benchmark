from locust import HttpLocust, TaskSet, task, between

class ArtistGetTasks(TaskSet):

    @task
    def artist(self):
        self.client.get("/cayenne/artist?cayenneExp=name like 'Ab%'")

    @task
    def artist_with_artset(self):
        self.client.get("/cayenne/artist?cayenneExp=name like 'Ab%'&include=artObjects")

    @task
    def artist_with_artset_with_department(self):
        self.client.get("/cayenne/artist?cayenneExp=name like 'Ab%'&include=artObjects&include=artObjects.department")

class WebsiteUser(HttpLocust):
    task_set = ArtistGetTasks
    wait_time = between(1, 2)
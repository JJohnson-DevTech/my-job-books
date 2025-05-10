<template>
  


    <div class="job-list-container">
    <router-link to="/add-job">
  <button>Add a job</button>
</router-link>
    <h2>My Jobs</h2>
    <div class="job-card" v-for="job in jobs" :key="job.id">
      <p class="job-name clickable" @click="goToJob(job.jobId)">{{ job.name }}</p>
      <p class="job-service">Service: {{ job.title }}</p>
      <p class="job-date">Date: {{ formatDate(job.jobDate) }}</p>
    </div>
  </div>



</template>

<script>
import JobService from '../services/JobService';
export default {
    data() {
        return {
            jobs: []
        }
    },

    created() {
        JobService.getJobs()
            .then(response => {
                this.jobs = response.data;
            })
            .catch(error => {
                console.error("There was an error fetching the jobs!", error);
            });
    },
    methods: {
    formatDate(datetimeString) {
  const date = new Date(datetimeString);
  return date.toLocaleString('en-US', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: 'numeric',
    minute: '2-digit',
    hour12: true
  });
},
  goToJob(jobId) {
      // Check if the courseId exists before redirecting
      if (jobId) {
        // Redirect to the CourseView with the courseId
        this.$router.push({ name: 'job-view', params: { id: jobId } });
      } else {
        console.error('No job ID found!');
        alert('Something went wrong. Please try again.');
      }
    },
    }

}
</script>


<style lang="scss" scoped>
@import "@/styles/jobs.scss";
</style>
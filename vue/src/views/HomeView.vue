<template>
  <div class="home">
    <h1>Hello {{ this.$store.state.user.firstName }} Welcome to MyJobBooks</h1>
    <p>
      This is a simple application to manage your job/clients. You can add,
      edit, and delete jobs. You can also view your jobs in a list or in a
      calendar view.
    </p>
  </div>
  <div class="job-list-container">
    <h2>My Jobs</h2>
    <div class="job-card" v-for="job in jobs" :key="job.id">
      <p class="job-name">{{ job.name }}</p>
      <p class="job-service">Service: {{ job.service }}</p>
      <p class="job-date">Date: {{ job.date }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      jobs: [
        { id: 1, name: "John Doe", service: "Service 1", date: "2023-10-01" },
        { id: 2, name: "Sammy Smith", service: "Service 2", date: "2023-10-02" },
        { id: 3, name: "Alex Cook", service: "Service 3", date: "2023-10-03" },
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
@import "@/styles/global.scss";
@import "@/styles/home.scss";
</style>

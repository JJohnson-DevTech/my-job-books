<template>

    <div class="jobh-card">
        <p class="job-name">Name: {{ job.name }}</p>
        <p class="job-service">Service: {{ job.title }}</p>
        <p class="job-date">Date: {{ formatDate(job.jobDate) }}</p>
        <p class="job-location">Location: {{ job.location }}</p>
        <p class="job-email">Email: {{ job.email }}</p>
        <p class="job-number">Phone Number: {{ job.number || 'Not provided' }}</p>
        <p class="job-material-cost">Material Cost: ${{ job.materialCost }}</p>
        <p class="job-price">Price: ${{ job.price }}</p>
        <router-link :to="'/edit-job/' + job.jobId" class=""><button>Edit Job</button></router-link>
    </div>



</template>

<script>
import JobService from '../services/JobService';

export default {

    data() {
        return {
            job: {
                title: "",
                name: "",
                email: '',
                number: '',
                location: '',
                jobDate: '',
                materialCost: '',
                price: '',
                userId: '',
            },
        };
    },
    created() {
        const username = this.$store.state.user.username;
        if (username) {
            JobService.getUserId(username).then(response => {
                this.job.userId = response.data;
            });
        }
        JobService.getJobById(this.$route.params.id).then(response => {
            this.job = response.data;
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

    }

}
</script>

<style lang="scss" scoped>
@import "@/styles/jobs.scss";
</style>
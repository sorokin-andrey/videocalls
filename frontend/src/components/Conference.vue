<template>
    <div id="conference" class="conference">
        <Camera />
        <Friends />
    </div>
</template>


<script>

import Camera from './Camera.vue'
import Friends from './Friends.vue'

export default {
    components: {
        Camera,
        Friends
    },
    methods: {
        fadeIn() {
            document.getElementById("conference").classList.add('fadeIn');
        }
    },
    mounted(){
        this.fadeIn()
    }
}

</script>


<style scoped lang="less">
    .conference {
        opacity: 0;
        position: absolute;
        z-index: 1;
        width: 100%;
    }
</style>
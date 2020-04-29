<template>
    <div class="conference">
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
    }
}

</script>


<style scoped lang="less">
    .conference {
        opacity: 0;
        // display: none;
        position: absolute;
        z-index: 1;
        width: 100%;
    }
</style>
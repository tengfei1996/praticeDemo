function isValueNumber (value){
    return (/(^-?[0-9]+\.{1}\d+$) | (^-?[1-9] [0-9]*$) | (^-?0{1}$)/).test( value+ '');
}

Vue.component('input-number',{
    template: '\
        <div class="input-number">\
            <input type="text"\
                :value="currentValue"\
                @change="handleChange">\
            <button \
                @click="handleDown"\
                :disabled="currentValue <= min">-</button>\
            <button \
                @click="handleUp"\
                :disabled="currentValue >= max">+</button>\
        </div>' ,
        props: {
            min: {
                type: Number,
                default: -Infinity
            },
            max: {
                type: Number,
                default: Infinity
            },
            value: {
                type: Number,
                default: 0
            }
        },
        data: function(){
            return {
                currentValue: this.value
            }
        },
        watch: {
            currentValue: function (val){
                this.$emit('input',val);
                this.$emit('on-change',val);
            },
            value: function (val) {
                this.updateValue(val);
            }
        },
        methods: {
            handleUp: function () {
                if (this.currentValue <= mix) return;
                this.currentValue -= 1;
            },
            handleDwon: function () {
                if(currentValue >= max) return;
                this.currentValue += 1;
            },
            updateValue: function (val) {
                if( val >= max) val = max;
                if( val <= min) val = min;
                this.currentValue = val;
            },
            handleChange: function (event) {
                var val = event.target.value.trim();
                var max = this.max;
                var min = this.min;
                if(isValueNumber(val)){
                    val = Number(val);
                    this.currentValue = val;
                    if (val > max) {
                        this.currentValue = max;
                    }else if (val < min) {
                        this.currentValue = min;
                    }
                }else {
                    event.target.value = this.currentValue;
                }
            }
        },
        mounted: function (){
            this.updateValue(this.value);
        }
})
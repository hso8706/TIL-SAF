<template>
    <div>
		<table>
			<tbody>
				<tr>
					<td>번호</td>
					<td>
						<input type="text" v-model="num" readonly class="inputBox" />
					</td>
				</tr>
				<tr>
					<td>할일</td>
					<td>
						<input type="text" v-model="content" class="inputBox" />
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>
						<input type="text" v-model="sdate" readonly class="inputBox" />
					</td>
				</tr>
				<tr>
					<td>기한</td>
					<td>
						<input type="text" v-model="edate" readonly class="inputBox" />
						<!-- <input type="date" v-model="edate" readonly class="inputBox" /> -->
					</td>
				</tr>
				<tr>
					<td>완료여부</td>
					<td>
						<input type="text" v-model="done"/>
					</td>
				</tr>
			</tbody>
		</table>
        <div>
			<button @click="modifyTodo">수정하기</button>
		</div>
	</div>
</template>

<script>
import http from "@/axios/axios-common.js"
export default {
    data() {
			return {
				// todo: [],
                num: "",
				userid: "",
                content: "",
                sdate: "",
                edate: "",
                done: ""
			};
	},
    created() {
        this.getTodo(this.$route.params.num);
    },
    methods: {
			getTodo(num) {
				http
					.get("/todoLists/" + num)
					.then((response) => {
						this.num = response.data.no;
						this.userid = response.data.userid;
						this.content = response.data.content;
						this.sdate = response.data.sdate;
						this.edate = response.data.edate;
						this.done = response.data.done;
					})
					.catch((exp) => alert("getTodo처리에 실패하였습니다." + exp));
			},

			modifyTodo() {
				http
					.put("/todoLists/modify", {
                        no: this.num,
                        content: this.content
                    })
					.then(() => {
						alert("수정하였습니다.");
						this.$router.push("/");
					})
					.catch((exp) => alert("modifyTodo처리에 실패하였습니다." + exp));
			},
		},    
}
</script>

<style scoped>
	input:focus {
		outline: none;
	}
	.inputBox {
		background: white;
		height: 50px;
		line-height: 50px;
		border-radius: 5px;
		width: 95%; /* add */
	}
	.inputBox input {
		border-style: none;
		font-size: 0.9rem;
	}

	.addContainer {
		background: linear-gradient(to right, #647811, #527810);
		display: inline-block;
		width: 3rem;
		border-radius: 5px 5px 5px 5px;
	}
	.checkBtn {
		color: white;
		vertical-align: middle;
	}

	table {
		width: 40%;
		margin: 10px auto;
		border-collapse: collapse;
		border: 2px solid #996;
		font: normal 90%/140% verdana, arial, helvetica, sans-serif;
		color: #333;
		background: #fffff0;
	}

	.caption {
		background-color: #222;
		vertical-align: middle;
		text-align: center;
		padding: 15px;
		font-size: 20px;
		color: #fff;
	}

	td,
	th {
		border: 1px solid #cc9;
		padding: 0.3em;
	}
	thead th,
	tfoot th {
		background-color: "#f5deb3";
		border: 1px solid #cc9;
		text-align: center;
		font-size: 1em;
		font-weight: bold;
		color: #444;
		background: #dbd9c0;
	}
	tbody td a {
		background: transparent;
		color: #72724c;
		text-decoration: none;
		border-bottom: 1px dotted #cc9;
	}
	tbody td a:hover {
		background: transparent;
		color: #666;
		border-bottom: 1px dotted #72724c;
	}
	tbody th a {
		background: transparent;
		color: #72724c;
		text-decoration: none;
		font-weight: bold;
		border-bottom: 1px dotted #cc9;
	}
	tbody th a:hover {
		background: transparent;
		color: #666;
		border-bottom: 1px dotted #72724c;
	}
	tbody th,
	tbody td {
		vertical-align: top;
		text-align: center;
	}
	tfoot td {
		border: 1px solid #996;
	}
	.odd {
		color: #333;
		background: #f7f5dc;
	}
	tbody tr:hover {
		color: #333;
		background: #fff;
	}
	tbody tr:hover th,
	tbody tr.odd:hover th {
		color: #333;
		background: #ddd59b;
	}
	tbody tr {
		height: 50px;
		line-height: 50px;
	}
</style>

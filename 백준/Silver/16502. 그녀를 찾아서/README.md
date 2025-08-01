# [Silver III] 그녀를 찾아서 - 16502 

[문제 링크](https://www.acmicpc.net/problem/16502) 

### 성능 요약

메모리: 14352 KB, 시간: 112 ms

### 분류

수학, 구현, 그래프 이론, 그래프 탐색, 시뮬레이션, 확률론

### 제출 일자

2025년 7월 26일 22:54:23

### 문제 설명

<p>그녀와 백화점을 가면 우리는 각자 따로따로 매장을 돌아다닌다. 중간에 그녀를 만나려면 어느 매장으로 가봐야 할까? 그녀는 백화점 쇼핑 중에는 전화벨로 방해받고 싶지 않아서 핸드폰을 꺼놓고 있다.</p>

<p>우리는 주어진 시간에 각 매장별로 그녀가 그 곳에 있을만한 확률을 보여주는 프로그램을 만들려고 한다.</p>

<p>입력은 유한한 그래프와 양의 정수이다. 그래프는 그녀의 움직임을 모델한 것이고, 움직임은 10분 단위로 일어난다고 하자. 양의 정수는 백화점에서 헤어진지 몇 10분 째인지를 나타낸다. 그래프의 노드는 매장을 의미하고, 노드 사이의 화살표는 한 매장에서 다른 매장으로 이동하는 관계이고, 화살표에는 그 이동의 확률이 표현되어 있다. 한 노드에서 바깥으로 가는 화살표가 여럿 있을 수 있는데 그 화살표 들에 적혀있는 확률들의 합은 반드시 1이어야 한다. 그녀가 백화점으로 들어와서 처음으로 방문하는 매장은 주어진 매장들 중에 같은 확률로 (무작위로) 정해진다고 하자</p>

<p>예를 들어, 그래프가</p>

<p><img alt="" src="https://upload.acmicpc.net/ab89f897-3087-404c-b208-439896ab36ad/-/preview/" style="width: 190px; height: 181px;"><br>
이면, A매장에서 B매장으로 항상 가고, B매장에서는 30% 확률로 C매장으로 움직이고, 등등.</p>

<p>이 경우, 임의의 매장에서 쇼핑을 시작해서 그녀가 10분후에 각 매장에 있을 확률은 A 15%, B 25%, C. 7.5%, D 52.5% 이다. 20분후는 각각 4.5%, 15%, 7.5%, 73% 이다.</p>

<p>위와 같은 결과를 계산하는 프로그램을 작성하라. 매장은 네개(A, B, C, D)로 정해져 있다고 가정한다. 입력은 다섯 매장을 다니는 그녀의 움직임 그래프와 쇼핑시간 (단위: 10분) 이다.</p>

### 입력 

 <p>첫째 줄에 쇼핑 시간 (단위: 10분)이 주어진다. 쇼핑 시간은 10보다 작거나 같은 자연수이다.</p>

<p>둘째 줄에는 간선의 개수 M이 주어진다. (1 ≤ M ≤ 10)</p>

<p>셋째 줄부터 M개의 줄에는 간선의 정보가 주어진다. 간선의 정보는 시작 매장, 도착 매장, 그리고 확률이다.</p>

### 출력 

 <p>각 매장 A, B, C, D에 그녀가 있을 확률을 퍼센트 단위로 출력한다. 절대/상대 오차는 10<sup>-2</sup>까지 허용한다.</p>

